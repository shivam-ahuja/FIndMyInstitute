package ahuja.shivam.findmyinstitute;

/**
 * Created by root on 7/5/17.
 */

public class CoursePOJOClass {
    private String course;
    private String course_detail;

    public void setCourse(String course)
    {
        this.course=course;
    }
    public void setCourseDetail(String coursedetail)
    {
        this.course_detail=coursedetail;
    }
    public String getCourse()
    {
        return course;
    }
    public String getCourseDetail()
    {
      return course_detail;
    }

}
