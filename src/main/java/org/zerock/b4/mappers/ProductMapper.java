package org.zerock.b4.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.zerock.b4.dto.PageRequestDTO;
import org.zerock.b4.dto.ProductDTO;
import org.zerock.b4.dto.ProductListDTO;
import org.zerock.b4.dto.ProductRegisterDTO;

public interface ProductMapper {
    
    List<ProductListDTO> getList(PageRequestDTO pageRequestDTO);

    int insertProduct(ProductRegisterDTO productRegisterDTO);

    int insertImages(List<Map<String, String>> imageList);

    @Select("SELECT * FROM tbl_product p WHERE p.pno = #{pno}")
    ProductDTO selectOne(Integer pno);

    @Select("SELECT concat(uuid, '_', fileName) FROM tbl_product_image WHERE pno = #{pno} order by ord")
    List<String> selectImages(Integer pno);

}
