package com.rosettcompany.api.error.classes;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper=false)
public class ErrorDetail extends  Detail{
	private long timeStamp;
	private int codeDeveloper;
	
	
	
}
