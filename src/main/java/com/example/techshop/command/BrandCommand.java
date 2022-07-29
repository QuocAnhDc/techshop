package com.example.techshop.command;

import com.example.techshop.command.abstractcommand.AbstractCommand;
import com.example.techshop.dto.BrandDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandCommand extends AbstractCommand<BrandDTO> {

  public BrandCommand() {
    this.pojo = new BrandDTO();
  }

  private Integer idDelete;
  private String value =  "";

}
