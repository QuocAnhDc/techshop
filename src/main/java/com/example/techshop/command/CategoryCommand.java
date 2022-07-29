package com.example.techshop.command;

import com.example.techshop.command.abstractcommand.AbstractCommand;
import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.CategoryDTO;
import com.example.techshop.dto.ProductDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class CategoryCommand extends AbstractCommand<CategoryDTO> {

  public CategoryCommand() {
    this.pojo = new CategoryDTO();
  }
  private Map<CategoryDTO, List<BrandDTO>> brandInCate;
  private Map<CategoryDTO, List<ProductDTO>> productInCate;

  private String value = "";

  private Integer idDelete;

}
