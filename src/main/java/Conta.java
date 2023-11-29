import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Autor: Vinicius
 */
public class Conta {

	public String nome;
    private int saldo;
    private int valor;
    private boolean especial;
    
    /**
     * Construtor para a classe Conta.
     * 
     * @param nome   Nome do titular da conta
     * @param espec  Indica se o cliente é especial
     */
    public Conta(String nome, boolean espec) {
    	this.nome = nome;
    	this.saldo = 0;
    	this.valor = 0;
    	this.especial = espec;
    }
	/**
     * Configuração inicial de um cliente com saldo negativo de 200 reais na conta.
     *
     * @param cliente Cliente utilizado
     */
    @Given("^Um cliente especial com saldo atual de -(\\d+) reais$")
    public void um_cliente_especial_com_saldo_atual_de_reais(Conta cliente){
    	saldo = -200;
    	if(cliente.especial = true) {
            System.out.println("Olá bom dia, "+cliente.nome+ " seu saldo é atualmente de "+saldo+" reais");
    	}else {
    		System.out.println("Nos pague "+cliente.nome+" seu saldo é atualmente de "+saldo+" reais");
    	}
    }

    /**
     * Define a solicitação de um saque de 100 reais na conta bancaria de um cliente especial e de 200 reais de um cliente comum.
     *
     * @param cliente Cliente utilizado
     */
    @When("^for solicitado um saque no valor de (\\d+) reais$")
    public void for_solicitado_um_saque_no_valor_de_reais(Conta cliente){
    	if(cliente.especial = true) {
    		valor = 100;
    		System.out.println("Atenção "+cliente.nome+ " Seu saldo é de "+saldo+" e você quer realizar um saque de "+valor +" reais");
    	}else {
    		valor = 200;
    			System.out.println("Atenção "+cliente.nome+ " Seu saldo é de "+saldo+" e você quer realizar um saque de "+valor +" reais");
    	}
    }

    /**
     * Verificação da efetuação correta do saque e atualização do saldo da conta.
     *
     * @param cliente Cliente utilizado
     */
    @Then("^deve efetuar o saque e atualizar o saldo da conta para -(\\d+) reais$")
    public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Conta cliente){
    	if(cliente.especial = true) {
    		cliente.saldo = cliente.saldo - valor;
            valor = 0;
            check_more_outcomes(cliente);
    	}else {
    		if(cliente.saldo<valor) {
    			System.out.println("Desculpe, "+cliente.nome+" você não pode efetuar um saque de "+valor+" reais");
    		}else {
    			cliente.saldo = cliente.saldo - valor;
                valor = 0;
                check_more_outcomes(cliente);
    		}}
    }

    /**
     * Averigua resultados adicionados e avisa o cliente após a operação de saque.
     *
     * @param cliente Cliente utilizado
     */
    @Then("^check more outcomes$")
    public void check_more_outcomes(Conta cliente){
    	 if(cliente.valor ==0) {
         	System.out.println("Parabéns "+cliente.nome+" seu saque foi concluído e seu saldo atual é de "+cliente.saldo+" reais");
         }else {
         	valor =0;
         }
     }
}