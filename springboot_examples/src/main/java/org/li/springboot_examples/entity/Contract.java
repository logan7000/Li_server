package org.li.springboot_examples.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contract {
    //adminName: "顾娟"
    String adminName;
    //amount: "170,000,000"
    int amount;
    //contractType: 2
    int contractType;
    //index: 1
    int index;
    //name: "沧州市办公用品采购项目"
    String name;
    //no: "BH0038"
    String no;
    //paymentType: 1
    int paymentType;
    //status: 4
    int status;
    //updateTime: "2020-05-30 14:05:44"
    String updateTime;
}
