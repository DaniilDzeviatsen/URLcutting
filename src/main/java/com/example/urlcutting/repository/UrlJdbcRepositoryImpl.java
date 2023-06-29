package com.example.urlcutting.repository;


import com.example.urlcutting.models.Link;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class UrlJdbcRepositoryImpl implements UrlJdbcRepository {
    private final JdbcOperations jdbcOperations;


    @Override
    public boolean ifShortenedUrlExists(String initialUrl) {
       /* String sql =
                """
                        select true
                        from link
                        where full_url = ?;
                        """;

        String result = jdbcOperations.query(sql, rs -> rs.getString("short_url")).
        return result.equals(initialUrl);*/
        return false;
    }

    @Override
    public void addNewLink(String initialUrl, String shortUrl) {
        jdbcOperations.update("""
                insert into link (full_url, short_url)
                values (? ?)
                """, initialUrl, shortUrl
        );
    }


    /* private Link mapToLink(ResultSet resultSet) throws SQLException {
        return new Link(
                resultSet.getString("initialUrl"),
                resultSet.getLong("id"),
                resultSet.getString("shortUrl")
        );
    }*/
}
