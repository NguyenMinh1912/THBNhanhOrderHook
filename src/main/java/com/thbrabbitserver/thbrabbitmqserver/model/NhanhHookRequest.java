package com.thbrabbitserver.thbrabbitmqserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NhanhHookRequest<T> {
    private String event;
    private Integer businessId;
    private String webhooksVerifyToken;
    private T data;

}
