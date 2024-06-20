package dev.mukul.split_wise.controller;

import dev.mukul.split_wise.dto.ResponseDTO;
import dev.mukul.split_wise.dto.SettleUpGroupRequestDTO;
import dev.mukul.split_wise.dto.SettleUpGroupResponseDTO;
import dev.mukul.split_wise.service.GroupService;
import dev.mukul.split_wise.service.strategies.settleUpStrategy.Transaction;
import org.springframework.http.HttpStatus;

import java.util.List;

public class GroupController {

    private GroupService groupService;
    public ResponseDTO<SettleUpGroupResponseDTO> settleUp(SettleUpGroupRequestDTO request){

        List<Transaction> transactionList = this.groupService.settleUp(request.getUserId(), request.getGroupId());
        ResponseDTO<SettleUpGroupResponseDTO> responseDTO = new ResponseDTO<SettleUpGroupResponseDTO>();
        SettleUpGroupResponseDTO settleUpGroupResponseDTO = new SettleUpGroupResponseDTO();
        settleUpGroupResponseDTO.setTransactions(transactionList);
        responseDTO.setCode(HttpStatus.OK);
        responseDTO.setData(settleUpGroupResponseDTO);

        return responseDTO;
    }
}
