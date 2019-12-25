/**
 * @(#)MyMapper.java, 2019/12/23. 16:23
 * @Author: L.Wen
 * <p/>
 */
package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 继承自 tk.mybatis 的通用 Mapper
 *
 * @Author: L.Wen
 * @created_at: 2019/12/23 16:23
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
