package ec.edu.espe.gpr.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class TareaIndicadorFile {
   
    private List<TareaIndicador> tareaIndicadors;

    private MultipartFile file;

    public TareaIndicadorFile(List<TareaIndicador> tareaIndicadors, MultipartFile file) {
        this.tareaIndicadors = tareaIndicadors;
        this.file = file;
    }

    public TareaIndicadorFile() {
    }

    public List<TareaIndicador> getTareaIndicadors() {
        return tareaIndicadors;
    }

    public void setTareaIndicadors(List<TareaIndicador> tareaIndicadors) {
        this.tareaIndicadors = tareaIndicadors;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    
}
