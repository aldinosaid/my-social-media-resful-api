package mysocialmedia.restful.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePostRequest {

    @NotBlank
    @Size(max = 100)
    private String userId;

    private String content;

    private String status;

    private String thumbnail;
}
