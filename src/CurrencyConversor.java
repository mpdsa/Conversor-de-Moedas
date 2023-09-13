
public class CurrencyConversor {
	String currencyText = "";
	double inputUser = 0;
	double result = 0;
	
	public CurrencyConversor(String currencyText, double inputUser) {
		this.currencyText = currencyText;
		this.inputUser = inputUser;
		
		if (currencyText == "De Reais para Dólares") this.result = fromRealToDollars(inputUser);
		if (currencyText == "De Reais para Euros") this.result = fromRealToEuro(inputUser);
		if (currencyText == "De Reais para Libras") this.result = fromRealToLibra(inputUser);
		if (currencyText == "De Reais para Yenes") this.result = fromRealToYenes(inputUser);
	}
	
	public double fromRealToDollars(double coin) { return coin * 4.95; }
	public double fromRealToEuro (double coin) { return coin * 5.32; }
	public double fromRealToLibra (double coin) { return coin * 6.18; }
	public double fromRealToYenes (double coin) { return coin * 0.034; }
	public double getResult() { return this.result; }
}
