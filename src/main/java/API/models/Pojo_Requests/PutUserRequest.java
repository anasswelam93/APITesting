package API.models.Pojo_Requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class PutUserRequest {
    public String name;
    public String job;
}
