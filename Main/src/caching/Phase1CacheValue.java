package caching;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

import ast.ExpCore;
import ast.ExpCore.ClassB;
import facade.L42;

public class Phase1CacheValue implements Serializable{
  public Phase1CacheValue(Set<String> usedNames, ClassB top) {
    this.usedNames = usedNames;
    this.top = top;
    }
private static final long serialVersionUID = 1L;
  Set<String> usedNames;
  ExpCore.ClassB top;
  public void saveOnFile(Path file){
    try (
      OutputStream os = Files.newOutputStream(file);
      ObjectOutputStream out = new ObjectOutputStream(os);
      )
      {out.writeObject(this);}
    catch(IOException i) {throw new Error(i);}
    }
  public static Phase1CacheKey readFromFile(Path file){
    try (
      InputStream is = Files.newInputStream(file);
      ObjectInputStream in = new ObjectInputStream(is);
      ){
      Object res = in.readObject();
      Phase1CacheKey cache=(Phase1CacheKey)res;
      return cache;
      }
    catch(IOException i) {throw new Error(i);}
    catch (ClassNotFoundException e) {throw new Error(e);}
    catch (ClassCastException e) {throw new Error(e);}//means file corrupted?
    }
  }