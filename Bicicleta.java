public class Bicicleta {
    private String cor, marca;
    private int aro;

    public Bicicleta(String cor, String marca, int aro){
        this.setCor(cor);
        this.setMarca(marca);
        this.setAro(aro);
    }

    public String getCor(){ return this.cor;}
    public void setCor(String cor){ this.cor = cor;}

    public String getMarca(){  return this.marca;}
    public void setMarca(String marca){ this.marca = marca;}

    public int getAro(){    return this.aro;}
    public void setAro(int aro){
        if  (aro < 12 || aro > 29)  System.out.println("Aro invalido. Nao foi possivel trocar");
        else    this.aro = aro;
    }
}
