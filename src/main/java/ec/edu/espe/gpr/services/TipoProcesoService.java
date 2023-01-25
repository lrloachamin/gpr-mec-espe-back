package ec.edu.espe.gpr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.espe.gpr.dao.ITipoProceso;
import ec.edu.espe.gpr.enums.EstadoProcesoEnum;
import ec.edu.espe.gpr.model.TipoProceso;

@Service
public class TipoProcesoService {
	
	@Autowired
	private ITipoProceso tipoProcesoDao;
	
	public TipoProceso obtenerPorCodigoTipoProceso(Integer codigoTipoProceso) {	
		Optional<TipoProceso> tipoProcesoOpt = this.tipoProcesoDao.findById(codigoTipoProceso);
		if (tipoProcesoOpt.isPresent())
			return tipoProcesoOpt.get();
		else 
			return null;
	}

	public List<TipoProceso> listarTiposProcesos() {
        return this.tipoProcesoDao.findAll();
    }

    public List<TipoProceso> listarTiposProcesosActivos() {
        return this.tipoProcesoDao.findByEstadoTipoProceso(EstadoProcesoEnum.ACTIVE.getValue());
    }
	
    public void crear(TipoProceso tipoProceso) {
        tipoProceso.setNombreTipoProceso(tipoProceso.getNombreTipoProceso().toUpperCase());
        tipoProceso.setNombreTipoProceso(EstadoProcesoEnum.ACTIVE.getValue());
        this.tipoProcesoDao.save(tipoProceso);
    }

    public TipoProceso modificarDatos(TipoProceso tipoProceso) {
        tipoProceso.setNombreTipoProceso(tipoProceso.getNombreTipoProceso().toUpperCase());
        this.tipoProcesoDao.save(tipoProceso);
        return tipoProceso;
    }

    public void cambiarEstadoProceso(Integer codigoTipoProceso) {
        TipoProceso tipoProceso = this.obtenerPorCodigoTipoProceso(codigoTipoProceso);
        if(tipoProceso.getEstadoTipoProceso().equals(EstadoProcesoEnum.ACTIVE.getValue()))
            tipoProceso.setEstadoTipoProceso(EstadoProcesoEnum.INACTIVE.getValue());
        else
            tipoProceso.setEstadoTipoProceso(EstadoProcesoEnum.ACTIVE.getValue());
        this.tipoProcesoDao.save(tipoProceso);
    }
}
