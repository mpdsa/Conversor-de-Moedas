
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;

public class Main {
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Initialization();
            }
        });
	}
	
	private static void Initialization() {
		
		try {
			FlatLaf.setup(new FlatAtomOneDarkIJTheme());
			UIManager.setLookAndFeel(new FlatAtomOneDarkIJTheme());
		}
	    catch (UnsupportedLookAndFeelException e) {
	       System.out.println(e.getMessage());
	    }
		
		String inputUser = "";
		int repeatConversor = 0;
		double convertedInputUser = 0;
		boolean checkOkInputUser = false;
		String[] optionConvertionType = {"Conversor de moeda", "Conversor de temperatura"};
		ArrayList<String> currencyTexts = new ArrayList<String>();
		currencyTexts.add("De Reais para Dólares");
		currencyTexts.add("De Reais para Euros");
		currencyTexts.add("De Reais para Libras");
		currencyTexts.add("De Reais para Yenes");
		
		do {
			
			Object inputSelected = JOptionPane.showInputDialog(null, "Escolha uma opção", "Menu", JOptionPane.INFORMATION_MESSAGE, null, optionConvertionType, optionConvertionType[0]);
			
			if (inputSelected == optionConvertionType[0]) {
				do {
					inputUser = JOptionPane.showInputDialog(null, "Insira o valor");
					
					try {
						convertedInputUser = Double.parseDouble(inputUser);
						checkOkInputUser = true;
						
					} catch(NumberFormatException | NullPointerException e) {
						JOptionPane.showConfirmDialog(null, "Valor inválido", "Erro", JOptionPane.OK_CANCEL_OPTION);
					}
					
				} while(!checkOkInputUser);
			}
			
			
		String currencyOption = JOptionPane.showInputDialog(null, "Escolha uma opção", "Menu", JOptionPane.INFORMATION_MESSAGE, null, currencyTexts.toArray(), currencyTexts.get(0)).toString();
		CurrencyConversor cc = new CurrencyConversor(currencyOption, convertedInputUser);
		
		JOptionPane.showMessageDialog(null, "O valor da conversão é de: R$" + cc.getResult());
		
		repeatConversor = JOptionPane.showConfirmDialog(null, "Deseja converter novamente?");
		} while (repeatConversor == 0);

		if (repeatConversor != 0 && repeatConversor != 1) {
			JOptionPane.showMessageDialog(null, "Programa concluído!", "Fim", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Programa finalizado!", "Fim", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}