package ec.edu.espe.gpr.response;


public class UsuarioResponseRest extends ResponseRest{
	private UsuarioResponse usuarioResponse= new UsuarioResponse();

	public UsuarioResponse getCategoryResponse() {
		return usuarioResponse;
	}

	public void setCategoryResponse(UsuarioResponse usuarioResponse) {
		this.usuarioResponse = usuarioResponse;
	}
	
	

}
