/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.text.NumberFormat;

/**
 *
 * @author hector
 */
public class employee {
    private String nombre;
    private String departamento;
    private float sueldo;
    public employee(String name, String department, float salary){
        this.nombre = name;
        this.departamento = department;
        this.sueldo = salary;
    }
    public String getName(){
        return nombre;
    }
    public void setName(String name){
        this.nombre = name;
    }
    public String getDepartment(){
        return departamento;
    }
    public void setDepartment(String department){
        this.departamento = department;
    }
    public float getSalary(){
        return sueldo;
    }
    public void setSalary(float salary){
        this.sueldo = salary;
    }
    @Override
    public boolean equals(Object o){
        boolean res = false;
        if((o != null) && (o instanceof employee)){
            employee e = (employee) o;
            if(getName().equals(e.getName()) && getDepartment().equals(e.getDepartment())){
                res = true;
            }
        }
        return res;
    }
    @Override
    public int hashCode(){
        return (getName().hashCode() ^ getDepartment().hashCode() ^ Float.hashCode(sueldo));
    }
    @Override
    public String toString(){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return "The employee " + this.nombre + " works on " + this.departamento + " and earn " + nf.format(sueldo);
    }
}
