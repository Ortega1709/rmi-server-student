package server;

import rmi.Student;
import rmi.StudentManagement;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class StudentServer extends UnicastRemoteObject implements StudentManagement {
    private List<Student> studentList = new ArrayList<>();

    public StudentServer() throws RemoteException {
        super();
    }

    @Override
    public List<Student> getAllStudents() throws RemoteException{
        return studentList;
    }

    @Override
    public List<Student> getStudentsByPromotion(String promotion) throws RemoteException {
        List<Student> students = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getPromotion().equals(promotion)) {
                students.add(student);
            }
        }

        return students;
    }

    @Override
    public void addStudent(String matricule, String name, String date, String promotion) throws RemoteException {
        studentList.add(new Student(matricule, name, date, promotion));
    }

    @Override
    public void updatePromotion(String matricule, String promotion) throws RemoteException {
        for (Student student : studentList) {
            if (student.getMatricule().equals(matricule)) {
                student.setPromotion(promotion);
            }
        }
    }

    @Override
    public void updateDate(String matricule, String date) throws RemoteException {
        for (Student student : studentList) {
            if (student.getMatricule().equals(matricule)) {
                student.setDateNaissance(date);
            }
        }
    }
}
