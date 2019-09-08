package com.ciwi.manager;

import java.util.*;

import com.ciwi.dao.MovieDAO;
import com.ciwi.vo.MovieVO;

public class MovieGenreManager {
	public static void main(String[] args) {
		Map map = new HashMap<>();
		map.put("searchOption", "Á¦¸ñ");
		List<MovieVO> list = MovieDAO.movieSearch(map);
		int i = 0;
		List<String> sList = new ArrayList<>();
		for (MovieVO vo : list) {
			String genre = vo.getGenre();
			System.out.println(genre);
			StringTokenizer st = new StringTokenizer(genre, ", ");
			while (st.hasMoreElements()) {
				String genreToken = st.nextToken();
				int flag = 0;
				if (sList.size() == 0) {
					sList.add(genreToken);
				} else {
					for (String s : sList) {
						if (s.equals(genreToken)) {
							flag = 1;
						}
					}
					if (flag == 0) {
						sList.add(genreToken);
					}
				}
			}
		}
		for (String s : sList) {
			System.out.print(s + " ");
		}

	}
}
