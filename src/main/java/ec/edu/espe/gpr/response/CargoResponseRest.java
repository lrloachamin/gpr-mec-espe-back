package ec.edu.espe.gpr.response;

public class CargoResponseRest extends ResponseRest {
	private CargoResponse cargoResponse= new CargoResponse();

	public CargoResponse getCargoResponse() {
		return cargoResponse;
	}

	public void setCargoResponse(CargoResponse cargoResponse) {
		this.cargoResponse = cargoResponse;
	}
}
