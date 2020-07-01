package principal;

import dao.AbstractProcessarDadosJob;
import model.WordList;

public class RecebimentoEmail extends AbstractProcessarDadosJob<WordList> {

	public RecebimentoEmail(int capacity) {
		super(capacity);
	}

}
