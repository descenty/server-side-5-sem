import 'cypress-plugin-api'
describe('Washing Machine CRUD', () => {
    let washingMachineId;
    it("Create", () => {
        cy.api({
            method: 'POST',
            url: '/washing-machines',
            body: {
                "title": "Samsung WW60K42109W",
                "price": 39999,
                "tankVolume": 6,
                "manufacturer": "Samsung",
                "sellerId": 3,
            }
        }).then(response => {
            expect(response.status).to.eq(201);
            expect(response.headers).to.have.property('location');
            washingMachineId = response.headers.location.split('/').pop();
        });
    });
    it('Get All', () => {
        cy.api('/washing-machines').then(response => {
            expect(response.status).to.eq(200);
            assert.isArray(response.body, 'Response Body is an Array')
        });
    });
    it('Get One', () => {
        cy.api(`/washing-machines/${washingMachineId}`).then(response => {
            expect(response.status).to.eq(200);
            assert.isObject(response.body, 'Response is an Object')
        });
    });
    it('Update', () => {
        cy.api({
            method: 'PATCH',
            url: `/washing-machines/${washingMachineId}`,
            body: {
                "price": 39998,
            }
        }).then(response => {
            expect(response.status).to.eq(200);
            expect(response.body.price).to.eq(39998);
        }
        );
    }
    );
    it('Get One Updated', () => {
        cy.api(`/washing-machines/${washingMachineId}`).then(response => {
            expect(response.status).to.eq(200);
            expect(response.body.price).to.eq(39998);
        }
        );
    }
    );
    it('Delete', () => {
        cy.api({
            method: 'DELETE',
            url: `/washing-machines/${washingMachineId}`,
        }).then(response => {
            expect(response.status).to.eq(204);
        });
    });
    it('Get One Deleted', () => {
        cy.api({
            method: 'GET',
            url: `/washing-machines/${washingMachineId}`,
            failOnStatusCode: false
        }).then(response => {
            expect(response.status).to.eq(404);
        });
    });
});
