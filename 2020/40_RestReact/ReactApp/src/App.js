import './App.css'
import Nav from './components/Nav'
import PersonList from './components/person/PersonList'
import AddPerson from './components/person/AddPerson'
import { PersonProvider } from './components/person/context/PersonContext'

function App() {
  return (
    <PersonProvider>
      <div className="App">
        <Nav />
        <AddPerson />
        <hr/>
        <PersonList />
      </div >
    </PersonProvider>
  );
}

export default App;
