/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entidad.Persona;
import java.util.Scanner;

/**
 *
 * @author Nico
 */
public class PersonaService {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Persona person = new Persona();
    Persona X = new Persona();
    private Persona crearPersona(){
        System.out.print("Nombre : ");
        person.setNombre(leer.next());
        System.out.print("Edad : ");
        person.setEdad(leer.nextInt());
        System.out.println("Sexo HOMBRE (H) / MUJER (M) / OTROS (O) : ");
        person.setSexo(leer.next().substring(0,1).toUpperCase());
        if(!person.getSexo().equals("H") && !person.getSexo().equals("M" ) && !person.getSexo().equals("O")){
            person.setSexo("Indefinido.");
        }
        System.out.print("Peso : ");
        person.setPeso(leer.nextDouble());
        System.out.print("Altura(en centimetros) : ");
        person.setAltura(leer.nextDouble());
        return person;
    }
    private Persona crearPNull(){
        return X;
    }
    private boolean esMayorDeEdad(Persona n) throws ArithmeticException{
        if(n.getEdad()==0){
            throw new ArithmeticException("Edad sin iniciar / Edad = 0");
        }
        boolean B = (n.getEdad() >= 18);
        
        return B;
        
    }
    private int IMC(Persona n)throws ArithmeticException{
        if(n.getPeso() == 0.0 && n.getAltura() == 0.0){
            throw new ArithmeticException("Peso y altura sin iniciar / Peso y altura = a 0.0");
        }
        double M;
        M = (n.getPeso()/(Math.pow(n.getAltura()/100, 2)));
        //IMC = peso en kg / (altura*altura m2)
        if(M < 20){
            return -1;
        } else if(M >= 20 && M <= 25){
            return 0;
        } else {
            return 1;
        }
    }
    public void verMain(){
        crearPNull();
        System.out.println(X.getNombre());
        System.out.println(X.getEdad());
        System.out.println(X.getSexo());
        System.out.println(X.getAltura());
        System.out.println(X.getPeso());
        try{
            esMayorDeEdad(X);
        }catch(ArithmeticException a){
            System.out.println(a.getMessage());
        }
        try{
            IMC(X);
        }catch(ArithmeticException b){
            System.out.println(b.getMessage());
        }
    }
}
