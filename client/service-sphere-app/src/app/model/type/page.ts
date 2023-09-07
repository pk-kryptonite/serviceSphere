export interface Page<T> {
    content: T[];
    pageable: {
        sort: {
            empty: false,
            unsorted: false,
            sorted: true
        },
        offset: 0,
        pageNumber: 0,
        pageSize: 10,
        unpaged: false,
        paged: true
    }
    totalPages: number;
    last: boolean;
    totalElements: number;
    sizes: number;
    number: number;
    sort: {
        empty: boolean;
        unsorted: boolean;
        sorted: boolean;
    };
    numberOfElements: number;
    first: boolean;
    empty: boolean;
}