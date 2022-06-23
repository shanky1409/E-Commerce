export class Customer {
    firstName: string
    lastName: string
    email: string
    phoneNumber: string
    address: Address

}
export class Address {

    public constructor() {
        this.addressLine1 = '';
        this.addressLine2 = '';
        this.city = '';
        this.state = '';
        this.zipCode = '';
    }
    addressLine1: string
    addressLine2: string
    city: string
    state: string
    zipCode: string
}

export class Product {
    category: string;
    description: string;
    id: string;
    imageUrl: string;
    name: string;
    price: number;
}

export class PageInformation {
    currentPage: number;
    hasNextPage: boolean;
    numberOfElements: number;
    totalPage: number;
}