/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

/**
 *
 * @author dhiral
 */
public class Currency {
    private String scurrency;
    private String dcurrency;
    private double crate;
    public Currency(String scurrency,String dcurrency,double crate){
        this.scurrency=scurrency;
        this.dcurrency=dcurrency;
        this.crate=crate;
    }
    public String getSourcecurrency(){
        return this.scurrency;
    }
    public String getDestinationcurrency(){
        return this.dcurrency;
    }
    public double getCurrencyrate(){
        return this.crate;
    }
}
