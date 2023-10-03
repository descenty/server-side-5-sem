import 'cypress-plugin-api'
describe('Book CRUD', () => {
    let bookId;
    it("Create", () => {
        cy.api({
            method: 'POST',
            url: '/books',
            body: {
                "title": "The Lord of the Rings",
                "author": "J. R. R. Tolkien",
                "price": 9.99,
                "sellerId": 1,
            }
        }).then(response => {
            expect(response.status).to.eq(201);
            expect(response.headers).to.have.property('location');
            bookId = response.headers.location.split('/').pop();
        });
    }
    );
    it('Get All', () => {
        cy.api('/books').then(response => {
            expect(response.status).to.eq(200);
            assert.isArray(response.body, 'Response Body is an Array');
        });
    });
    it('Get One', () => {
        cy.api(`/books/${bookId}`).then(response => {
            expect(response.status).to.eq(200);
            assert.isObject(response.body, 'Response is an Object');
        });
    });
    it('Update', () => {
        cy.api({
            method: 'PATCH',
            url: `/books/${bookId}`,
            body: {
                "price": 14.99,
            }
        }).then(response => {
            expect(response.status).to.eq(200);
            expect(response.body.price).to.eq(14.99);
        });
    });
    it('Get One Updated', () => {
        cy.api(`/books/${bookId}`).then(response => {
            expect(response.status).to.eq(200);
            expect(response.body.price).to.eq(14.99);
        });
    });
    it('Delete', () => {
        cy.api({
            method: 'DELETE',
            url: `/books/${bookId}`,
        }).then(response => {
            expect(response.status).to.eq(204);
        });
    });
    it('Get One Deleted', () => {
        cy.api({
            method: 'GET',
            url: `/books/${bookId}`,
            failOnStatusCode: false
        }).then(response => {
            expect(response.status).to.eq(404);
        });
    });
});