import 'cypress-plugin-api'
describe('Client CRUD', () => {
    let clientId;
    it("Create", () => {
        cy.api({
            method: 'POST',
            url: '/clients',
            body: {
                "name": "John Doe",
                "email": "johndoe@mail.com",
                "login": "johndoe",
                "password": "qweasdzxc",
            }
        }).then(response => {
            expect(response.status).to.eq(201);
            expect(response.headers).to.have.property('location');
            clientId = response.headers.location.split('/').pop();
        });
    });
    it('Get All', () => {
        cy.api('/clients').then(response => {
            expect(response.status).to.eq(200);
            assert.isArray(response.body, 'Response Body is an Array')
        });
    });
    it('Get One', () => {
        cy.api(`/clients/${clientId}`).then(response => {
            expect(response.status).to.eq(200);
            assert.isObject(response.body, 'Response is an Object')
        });
    });
    it('Update', () => {
        cy.api({
            method: 'PATCH',
            url: `/clients/${clientId}`,
            body: {
                "email": "doejohn@rambler.com",
            }
        }).then(response => {
            expect(response.status).to.eq(200);
            expect(response.body.email).to.eq("doejohn@rambler.com");
        }
        );
    }
    );
    it('Get One Updated', () => {
        cy.api(`/clients/${clientId}`).then(response => {
            expect(response.status).to.eq(200);
            expect(response.body.email).to.eq("doejohn@rambler.com");
        }
        );
    }
    );
    it('Delete', () => {
        cy.api({
            method: 'DELETE',
            url: `/clients/${clientId}`,
        }).then(response => {
            expect(response.status).to.eq(204);
        }
        );
    }
    );
    it('Get One Deleted', () => {
        cy.api({
            method: 'GET',
            url: `/clients/${clientId}`,
            failOnStatusCode: false
        }).then(response => {
            expect(response.status).to.eq(404);
        }
        );
    }
    );
});