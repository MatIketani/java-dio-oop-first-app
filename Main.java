import java.util.*;

// Exercício 3 - P.O.O

class GasTank {
    private int capacity;
    private int fuel;

    // Overload que cria um tanque cheio.
    GasTank(int capacity){
        this.capacity = capacity;
        this.fuel = 0;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public void setCapacity(int value){
        this.capacity = value;
    }

    public int getFuel(){
        return this.fuel;
    }

    public void setFuel(int value){
        this.fuel = Math.min(value, this.capacity);
    }
}

class Car {
    private String modelo;
    private String cor;
    private GasTank gasTank;

    private double gasPrice = 5.00;

    Car(String modelo, String cor){
        this.modelo = modelo;
        this.cor = cor;
        this.gasTank = new GasTank(40);
    }

    Car(String modelo, String cor, int fuel){
        this.modelo = modelo;
        this.cor = cor;
        this.gasTank = new GasTank(fuel);
    }

    public double fillGasTank(){

        gasTank.setFuel(gasTank.getCapacity());
        return gasPrice * gasTank.getCapacity();
    }

    public double fillGasTank(int value){
        gasTank.setFuel(value);
        return gasPrice * value;
    }

    public int getFuel(){
        return gasTank.getFuel();
    }

    public int getCapacity(){
        return gasTank.getCapacity();
    }

    public String getModelo(){
        return this.modelo;
    }

    public String getCor(){
        return this.cor;
    }
}

// Exercício 4 P.O.O

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o modelo do veículo a ser criado:");
        String modelo = sc.nextLine();

        System.out.println("Digite a cor do veículo a ser criado:");
        String cor = sc.nextLine();

        Car carro = new Car(modelo, cor);
        System.out.println("Carro de modelo " + modelo + " e cor " + cor + " criado com sucesso!");

        if(carro.getFuel() == 0){
            System.out.print("O tanque do veículo veio vazio, o que fazer?\n[1] Encher tanque\n[2] Escolher quantidade de gasolina.\n> ");
            int option = sc.nextInt();

            switch(option){
                case 1:
                    double gasValue = carro.fillGasTank();
                    System.out.println("Você encheu o tanque de " + carro.getCapacity() + " de seu " + carro.getModelo() + " " + carro.getCor() + " e gastou R$" + gasValue);
                    break;
                case 2:
                    System.out.print("Digite o quanto de gasolina quer encher\n> ");
                    int value = sc.nextInt();
                    gasValue = carro.fillGasTank(value);
                    System.out.println("Você colocou " + value + " litros de gasolina em seu " + carro.getModelo() + " " + carro.getCor() + " e gastou R$" + gasValue + ", o tanque está em " + ((carro.getFuel() / carro.getCapacity()) * 100) + "% de capacidade.");
                    break;
            }
        }
    }
}
