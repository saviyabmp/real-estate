package com.bmp.saviya.realestate.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ProductStatus {
	ACTIVE(1), INACTIVE(0);

	private int status;

	private ProductStatus(int status) {
		this.status = status;
	}

	public static ProductStatus fromInt(int status) {
		for (ProductStatus pstatus : ProductStatus.values()) {
			if (pstatus.status == status)
				return pstatus;
		}

		return null;
	}

}
