// Joshua Ungheanu 897883294

package com.example.Hmwk2p2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.Hmwk2p2.model.Student;
import com.example.Hmwk2p2.model.StudentDB;
import com.example.Hmwk2p2.model.CourseEnrollment;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    LinearLayout root;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createStudentObjects();
        setContentView(R.layout.student_summary);

        root = findViewById(R.id.student_summary);

        ArrayList<Student> studentList = StudentDB.getInstance().getStudents();
        for (int i=0; i<studentList.size(); i++) {
            Student s = studentList.get(i);
            LayoutInflater inflater = LayoutInflater.from(this);
            View row_view = inflater.inflate(R.layout.student_row, root, false);

            TextView firstName = (TextView) row_view.findViewById(R.id.first_name);
            firstName.setText(s.getFirstName());

            TextView lastName = (TextView) row_view.findViewById(R.id.last_name);
            lastName.setText(s.getLastName());

            TextView CWID = (TextView) row_view.findViewById(R.id.CWID);
            CWID.setText(s.getCWID());
            root.addView(row_view);
        }
    }

    protected void createStudentObjects() {
        Student s1 = new Student("Josh", "Ungheanu", 88888888);
        ArrayList<CourseEnrollment> courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC411", "A"));
        courses.add(new CourseEnrollment("CPSC440", "C"));
        s1.setCourses(courses);

        Student s2 = new Student("Bob", "Dylan", 11111111);
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC240", "A"));
        s2.setCourses(courses);

        Student s3 = new Student("Donald", "Trump", 22222222);
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC444", "F"));
        s3.setCourses(courses);

        ArrayList<Student>studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);

        StudentDB.getInstance().setStudents(studentList);
    }
}
