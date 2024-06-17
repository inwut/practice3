package org.ukma;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Book {
    @NonNull
    private String title;
    @NonNull
    private String author;
    @NonNull
    private int numberOfPages;
    private boolean isRead;

    public void markAsRead() {
        this.isRead = true;
    }

}
