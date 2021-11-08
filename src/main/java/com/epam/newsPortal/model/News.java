package com.epam.newsPortal.model;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@NamedQueries
        ({
                @NamedQuery(
                        name = "all_news_order_by_date",
                        query = "from News order by date"
                )
        })

@Entity
@Table(name = "news")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
@DynamicUpdate
public class News {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(name = "title")
    private String title;
    @NonNull
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @NonNull
    @Column(name = "brief")
    private String brief;
    @NonNull
    @Column(name = "content")
    private String content;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id.equals(news.id) && title.equals(news.title) && date.equals(news.date) && brief.equals(news.brief) && content.equals(news.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, date, brief, content);
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
