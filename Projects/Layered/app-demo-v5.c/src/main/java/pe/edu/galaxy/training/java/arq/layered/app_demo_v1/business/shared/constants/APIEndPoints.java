package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.shared.constants;

public class APIEndPoints {

    public static final String API_VERSION="v1";

    public static final String API_CUSTOMER = "/api/" + API_VERSION + "/customers";
    public static final String API_SUPPLIER = "/api/" + API_VERSION + "/suppliers";

    //public static final String API_CUSTOMER_DOCUMENT_NUMBER = API_CUSTOMER + "/document-number/{documentNumber}";
    public static final String API_SUPPLIER_DOCUMENT_NUMBER = "/document-number/{documentNumber}";

}
