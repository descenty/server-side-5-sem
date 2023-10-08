import 'cypress-plugin-api'
describe('Telephone CRUD', () => {
    let telephoneId;
    it("Create", () => {
        cy.api({
            method: 'POST',
            url: '/telephones',
            body: {
                "title": "Iphone 12",
                "price": 62499,
                "batteryCapacity": 2815,
                "manufacturer": "Apple",
                "sellerId": 2,
            }
        }).then(response => {
            expect(response.status).to.eq(201);
            expect(response.headers).to.have.property('location');
            telephoneId = response.headers.location.split('/').pop();
        });
    });
    it('Get All', () => {
        cy.api('/telephones').then(response => {
            expect(response.status).to.eq(200);
            assert.isArray(response.body, 'Response Body is an Array')
        });
    });
    it('Get One', () => {
        cy.api(`/telephones/${telephoneId}`).then(response => {
            expect(response.status).to.eq(200);
            assert.isObject(response.body, 'Response is an Object')
        });
    });
    it('Update', () => {
        cy.api({
            method: 'PATCH',
            url: `/telephones/${telephoneId}`,
            body: {
                "price": 62498,
            }
        }).then(response => {
            expect(response.status).to.eq(200);
            expect(response.body.price).to.eq(62498);
        }
        );
    }
    );
    it('Get One Updated', () => {
        cy.api(`/telephones/${telephoneId}`).then(response => {
            expect(response.status).to.eq(200);
            expect(response.body.price).to.eq(62498);
        }
        );
    }
    );
    it('Delete', () => {
        cy.api({
            method: 'DELETE',
            url: `/telephones/${telephoneId}`,
        }).then(response => {
            expect(response.status).to.eq(204);
        }
        );
    }
    );
    it('Get One Deleted', () => {
        cy.api({
            method: 'GET',
            url: `/telephones/${telephoneId}`,
            failOnStatusCode: false
        }).then(response => {
            expect(response.status).to.eq(404);
        }
        );
    }
    );
}
);
