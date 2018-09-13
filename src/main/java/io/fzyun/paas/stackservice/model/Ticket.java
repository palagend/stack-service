package io.fzyun.paas.stackservice.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 工单
 *
 * @author 胡月恒
 * @mail huyh@founder.com
 * @date 2018-09-13
 */
@Data
public class Ticket {
    String stackId;

    List<Bundle> inventory = new ArrayList<>();
}
