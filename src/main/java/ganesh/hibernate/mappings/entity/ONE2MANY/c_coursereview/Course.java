package ganesh.hibernate.mappings.entity.ONE2MANY.c_coursereview;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ganesh.hibernate.CRUD.entity.Student;
import ganesh.hibernate.mappings.entity.ONE2ONE.Instructor;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private List<CourseReview> courseReviews;

	// @formatter:off
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "course_student", 
				joinColumns = @JoinColumn(name = "course_id"), 
				inverseJoinColumns = @JoinColumn(name = "student_id"))
	// @formatter:on
	private List<Student> students;

	public Course() {
	}

	public Course(String title) {
		this.setTitle(title);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<CourseReview> getCourseReviews() {
		return courseReviews;
	}

	public void setCourseReviews(List<CourseReview> courseReviews) {
		this.courseReviews = courseReviews;
	}

	public void addCourseReview(CourseReview courseReview) {
		if (courseReviews == null) {
			courseReviews = new ArrayList<>();
		}
		courseReviews.add(courseReview);
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void addStudent(Student student) {
		if (students == null) {
			students = new ArrayList<>();
		}
		students.add(student);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
}
