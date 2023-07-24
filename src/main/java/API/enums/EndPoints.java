package API.enums;

import lombok.Getter;

public enum EndPoints {


    PUSH("/push/"),
    USERS( "/api/users"),

    KEY( "/api/users/2"),
    PN_AuthKey ("cFFXoew5TMCg9cCB2FhYUA"),
    PN_AuthValue ("HUrQlejpSpWZt4dkdzwrVA");
    @Getter
    private final String value;
    EndPoints(String value) {
        this.value = value;
    }


}
