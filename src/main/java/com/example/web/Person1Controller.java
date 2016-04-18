/**
 * @创建人：石永强
 * @创建时间：　2016年4月16日下午11:38:04
 * @类名：　Person1Controller
 * @说明：
 * @修改人：
 * @修改时间：
 * @修改说明
 */
package com.example.web;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Person1Controller {
	@RequestMapping(value="/upload",method=RequestMethod.GET)
	public String upload(){  
		return "upload";		
	}
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String uploadPost(MultipartFile file, String name,Model model){
		try {
			FileUtils.writeByteArrayToFile(new File("/home/shiyq/upload/"+file.getOriginalFilename()), file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name);
		model.addAttribute("name",name);
		return "upload_result";		
	}
}
