package ua.com.Bershka.util;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import ua.com.Bershka.dto.filter.SimpleFilter;

public class ParamBuilder {

	public static String getParams(Pageable pageable){
		StringBuilder builder = new StringBuilder();
		builder.append("?page=");
		builder.append(String.valueOf(pageable.getPageNumber()+1));
		builder.append("&size=");
		builder.append(String.valueOf(pageable.getPageSize()));
		if(pageable.getSort()!=null){
			builder.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order)->{
				builder.append(order.getProperty());
				if(order.getDirection()!=Direction.ASC)
					builder.append(",desc");
			});
		}
		return builder.toString();
	}
	
	public static String getParams(Pageable pageable, SimpleFilter filter){
		StringBuilder builder = new StringBuilder();
		builder.append("?page=");
		builder.append(String.valueOf(pageable.getPageNumber()+1));
		builder.append("&size=");
		builder.append(String.valueOf(pageable.getPageSize()));
		if(pageable.getSort()!=null){
			builder.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order)->{
				builder.append(order.getProperty());
				if(order.getDirection()!=Direction.ASC)
					builder.append(",desc");
			});
		}
		if(!filter.getSearch().isEmpty()){
			builder.append("&search=");
			builder.append(filter.getSearch());
		}
		return builder.toString();
	}
}
