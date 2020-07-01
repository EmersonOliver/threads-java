package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.WordList;

public class DaoWordList {

	public void saveWordList(String... dados) throws Exception {
		try {
			ConnectionDao.abrirConexao();
			StringBuilder insert = new StringBuilder();
			insert.append("INSERT INTO wordlist.tb_wordlist (word) VALUES (?) ");

			PreparedStatement ps = ConnectionDao.getConnection().prepareStatement(insert.toString());
			for (int i = 0; i < dados.length; i++) {
				ps.setString(1, dados[i]);
				ps.addBatch();
			}
			ps.executeBatch();
			ConnectionDao.fecharConexao();

		} catch (Exception e) {
			throw new Exception();
		}
	}

	public List<WordList> getWordList() {
		List<WordList> result = new ArrayList<>();
		try {
			ConnectionDao.abrirConexao();

			ResultSet rs = ConnectionDao.getConnection().createStatement()
					.executeQuery("SELECT id, word FROM wordlist.tb_wordlist ");
			while (rs.next()) {
				WordList w = new WordList();
				w.setId(rs.getInt(1));
				w.setWord(rs.getString(2));
				result.add(w);
			}
			ConnectionDao.fecharConexao();
			return result;

		} catch (Exception e) {
			return new ArrayList<>();
		}

	}

}
