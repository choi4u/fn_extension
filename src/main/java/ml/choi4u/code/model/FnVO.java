package ml.choi4u.code.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FnVO {

	private String fn;
	private String createDate;
	private String def;
	private String useYn;
	
}
