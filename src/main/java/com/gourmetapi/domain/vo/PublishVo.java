package com.gourmetapi.domain.vo;

import com.gourmetapi.domain.GourmetMaterials;
import com.gourmetapi.domain.GourmetMenu;

import java.util.List;

/**
 * @author 李发展
 * @date 2020-10-23 - 19:08
 *
 * 菜谱上传的包装类
 */
public class PublishVo {

    // 菜谱的id 在生成菜谱实体不会使用此参数，若要使用需要自行设置
    private int id;

    private String img;

    private String title;

    private String introd;

    private String nickname;

    private Boolean recommend;

    private String content;

    private List<GourmetMaterials> materials;

    /**
     * 获取菜单实体
     * @return
     */
    public GourmetMenu getGourmetMenu(){
        GourmetMenu menu = new GourmetMenu();
        menu.setImg(this.img);
        menu.setTitle(this.title);
        menu.setIntrod(this.introd);
        menu.setNickname(this.nickname);
        menu.setRecommend(false);
        menu.setContent(this.content);

        return menu;

    }

    @Override
    public String toString() {
        return "PublishVo{" +
                "img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", introd='" + introd + '\'' +
                ", nickname='" + nickname + '\'' +
                ", recommend=" + recommend +
                ", content='" + content + '\'' +
                ", materials=" + materials +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntrod() {
        return introd;
    }

    public void setIntrod(String introd) {
        this.introd = introd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<GourmetMaterials> getMaterials() {
        return materials;
    }

    public void setMaterials(List<GourmetMaterials> materials) {
        this.materials = materials;
    }
}
