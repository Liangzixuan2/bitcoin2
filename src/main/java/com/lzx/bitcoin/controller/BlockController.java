package com.lzx.bitcoin.controller;

import com.lzx.bitcoin.dto.BlockDetailDTO;
import com.lzx.bitcoin.dto.BlockListDTO;
import com.lzx.bitcoin.mapper.BlockMapper;
import com.lzx.bitcoin.mapper.BlockchainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/block")
public class BlockController {

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private BlockchainMapper blockchainMapper;

    //通过blockchainId获取当前块信息
    @GetMapping("/getRecentBlocksById")
    public List<BlockListDTO> getRecentBlocksById(@RequestParam Integer blockchainId){
        List<BlockListDTO> BlockListDTO = blockMapper.getRecentBlocksById(blockchainId);
        return BlockListDTO;
    }

    //通过name和type获取当前块信息
    @GetMapping("/getRecentBlocksByNameType")
    public List<BlockListDTO> getRecentBlocksByNameType(@RequestParam String name,@RequestParam String type){
        Integer blockchainid = blockchainMapper.getblockchainId(name,type);
        List<BlockListDTO> BlockListDTO = blockMapper.getRecentBlocksById(blockchainid);
        return BlockListDTO;
    }

    //通过blockhash查询块信息
    @GetMapping("/getBlockDetailByHash")
    public BlockDetailDTO getBlockDetailByHash(@RequestParam String blockhash){
        BlockDetailDTO blockDetailDTO = blockMapper.getBlockDetailByHash(blockhash);
        return blockDetailDTO;
    }

    //通过blockheight查询块信息
    @GetMapping("/getBlockDetailByHeight")
    public BlockDetailDTO getBlockDetailByHeight(@RequestParam Integer blockheight){
        BlockDetailDTO blockDetailDTO = blockMapper.getBlockDetailByHeight(blockheight);
        return blockDetailDTO;
    }
}
