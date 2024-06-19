package dev.mukul.split_wise.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
public class ResponseDTO<T> {
    public HttpStatusCode code;
    public T data;
}



// ArrayList<Animal>
// HashMap<Animal, Long>

// class HashMap<T, X> {
//   private List<T> keys;
//   private List<X> values;
// }