package we.codered.rokomari.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import we.codered.rokomari.beans.FileBucket;
import we.codered.rokomari.beans.MultiFileBucket;
import we.codered.rokomari.util.FileValidator;
import we.codered.rokomari.util.MultiFileValidator;

@Controller
public class FileUploadController {
	private static String UPLOAD_LOCATION = "D:/data/";

	@Autowired
	FileValidator fileValidator;

	@InitBinder("fileBucket")
	protected void initBinderFileBucket(WebDataBinder binder) {
		binder.setValidator(fileValidator);
	}

	@RequestMapping(value = "/fileup", method = RequestMethod.GET)
	public String getSingleUploadPage(ModelMap model) {
		model.addAttribute("fileBucket", new FileBucket());
		return "fileup";
	}

	@RequestMapping(value = "/fileup", method = RequestMethod.POST)
	public String singleFileUpload(@Validated FileBucket fileBucket, BindingResult result, ModelMap model)
			throws IOException {

		if (result.hasErrors()) {
			System.out.println("validation errors");
			return "fileup";
		} else {
			System.out.println("Fetching file");
			MultipartFile multipartFile = fileBucket.getFile();

			// Now do something with file...
			FileCopyUtils.copy(fileBucket.getFile().getBytes(),
					new File(UPLOAD_LOCATION + fileBucket.getFile().getOriginalFilename()));

			String fileName = multipartFile.getOriginalFilename();
			model.addAttribute("fileName", fileName);
			return "login";
		}
	}

}
