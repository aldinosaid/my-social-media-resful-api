package mysocialmedia.restful.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

    private Long id;

    private Long userId;

    private String content;

    private String thumbnail;

    // private Date createdDate;

    // private Date modifiedDate;

    private String status;
}
