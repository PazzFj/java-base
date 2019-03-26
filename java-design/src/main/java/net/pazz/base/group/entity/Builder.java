package net.pazz.base.group.entity;

public class Builder {

    private Long id;
    private Long courseId;
    private String content;

    public Long getId() {
        return id;
    }

    public Builder setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getCourseId() {
        return courseId;
    }

    public Builder setCourseId(Long courseId) {
        this.courseId = courseId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Builder setContent(String content) {
        this.content = content;
        return this;
    }
}
