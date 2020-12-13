package com.devil.web;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.devil.domain.Tag;
import com.devil.domain.User;
import com.devil.service.TagService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
@RequestMapping("/tag")
public class TagController {

  @Autowired
  ServletContext servletContext;

  @Autowired
  TagService tagService;

  @RequestMapping("/form")
  public ModelAndView form() throws Exception {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/tag/form.jsp");

    return mv;
  }

  @RequestMapping("/add")
  public String add(String name, String tagColor, String fontColor, Part photoFile)
      throws Exception {
    String filename = UUID.randomUUID().toString();
    String saveFilePath = servletContext.getRealPath("/upload/tag/" + filename);

    Tag tag = new Tag();
    tag.setName(name);
    tag.setTagColor(tagColor);
    tag.setFontColor(fontColor);

    photoFile.write(saveFilePath);
    tag.setPhoto(filename);

    generatePhotoThumbnail(saveFilePath);
    tagService.add(tag);
    return "redirect:list";
  }

  @RequestMapping("/detail")
  public ModelAndView detail(int no) throws Exception {
    Tag tag = tagService.get(no);
    if (tag == null) {
      throw new Exception("해당 태그가 없습니다!");
    }

    ModelAndView mv = new ModelAndView();
    mv.addObject("tag", tag);
    mv.setViewName("/tag/detail.jsp");
    return mv;
  }

  @RequestMapping("/list")
  public ModelAndView list(HttpSession session, HttpServletResponse response) throws Exception {

    User loginUser = (User) session.getAttribute("loginUser");

    List<Integer> userTagNoList = new ArrayList<>();
    for (Tag tag : tagService.list(loginUser)) {
      userTagNoList.add(tag.getNo());
    }

    ModelAndView mv = new ModelAndView();
    mv.addObject("tags", tagService.list((String) null));
    mv.addObject("userTagNoList", userTagNoList);
    mv.setViewName("/tag/list.jsp");

    return mv;
  }

  @RequestMapping("/update")
  public String update(int no, String name, String tagColor, String fontColor) throws Exception {

    Tag tag = new Tag();
    tag.setName(name);
    tag.setNo(no);
    tag.setTagColor(tagColor);
    tag.setFontColor(fontColor);

    tagService.update(tag);
    return "redirect:detail?no=" + tag.getNo();
  }

  @RequestMapping("/updatePhoto")
  public String updatePhoto(int no, Part photoFile) throws Exception {

    Tag tag = new Tag();
    tag.setNo(no);

    // 태그 사진 파일 저장
    if (photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      String saveFilePath = servletContext.getRealPath("/upload/tag/" + filename);
      photoFile.write(saveFilePath);
      tag.setPhoto(filename);

      generatePhotoThumbnail(saveFilePath);
    }

    if (tag.getPhoto() == null) {
      throw new Exception("사진을 선택하지 않았습니다.");
    }

    tagService.update(tag);

    return "redirect:detail?no=" + tag.getNo();
  }

  @RequestMapping("/delete")
  public String delete(int no) throws Exception {
    if (tagService.delete(no) == 0) {
      throw new Exception("해당 번호의 태그가 없습니다.");
    }
    return "redirect:list";
  }

  private void generatePhotoThumbnail(String saveFilePath) {
    try {
      Thumbnails.of(saveFilePath).size(40, 40).crop(Positions.CENTER).outputFormat("png")
          .toFiles(new Rename() {
            @Override
            public String apply(String name, ThumbnailParameter param) {
              return name + "_40x40";
            }
          });

      Thumbnails.of(saveFilePath).size(80, 80).outputFormat("png").toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_80x80";
        }
      });

      Thumbnails.of(saveFilePath).size(160, 160).outputFormat("png").crop(Positions.CENTER)
          .toFiles(new Rename() {
            @Override
            public String apply(String name, ThumbnailParameter param) {
              return name + "_160x160";
            }
          });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
