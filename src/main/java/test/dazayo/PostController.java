package test.dazayo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostDao postDao;
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	@ResponseBody
	public Post add(Post post){
		Post postData = postDao.save(post);
		return postData;
	}
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String add(){
		return "post/add";
	}
	
	@RequestMapping("/view/{id}")
	@ResponseBody
	public Post view(@PathVariable int id){
		Post postData = postDao.findOne(id);
		return postData;
	}	

	@RequestMapping("/list")
	public String list(Model model){
		List<Post> postList = postDao.findAll();
		model.addAttribute("list",postList);
		return "post/list";
	}
	
	@RequestMapping("/del/{id}")
	public String del(@PathVariable int id){
		postDao.delete(id);
		return "redirect:/post/list";
	}
	@RequestMapping(value = "/mod/{id}", method = RequestMethod.GET)
	public String editor(Model model, @PathVariable int id) {
		Post post = postDao.findOne(id);
		model.addAttribute("post", post);
		return "post/mod";
	}
	
	@RequestMapping(value="/mod/{id}",method = RequestMethod.POST)
	public String postMod(@Valid Post post, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return "post/mod";
		}
		return "/post/view/" + postDao.save(post).getId();
	}
	
	
	// web :: 
	@RequestMapping("/jsp")
	public String jspPage(Model model){
		model.addAttribute("name","hello springBoot1234");
		return "hi";
	}
	
	@RequestMapping("/")
	public String index(){
		return "helloHome";
	}
}


